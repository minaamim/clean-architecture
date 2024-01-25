package ddd.teople.cleanarchitecture.sample.adapter.out.persistencce

import com.querydsl.jpa.impl.JPAQueryFactory
import ddd.teople.cleanarchitecture.sample.adapter.out.persistencce.dto.QSampleDto
import ddd.teople.cleanarchitecture.sample.adapter.out.persistencce.dto.SampleDto
import ddd.teople.cleanarchitecture.sample.domain.QSample
import ddd.teople.cleanarchitecture.sample.domain.Sample
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class SampleRepositoryImpl(
    @Qualifier("teopleQueryFactory")
    private val queryFactory: JPAQueryFactory
) {

    // QueryDSL에서는 QClass를 사용
    // "gradle clean build"를 통해 빌드실행시 @Entity 어노테이션을 scan해서 자동으로 QClass 생성
    // QClass 생성 위치도 설정할 수 있으나 굳이 해두진 않음
    private val sample = QSample.sample!!

    // 하나의 테이블이 아니라 여러 테이블의 필드를 섞어서 조회해야할 경우, 별도의 DTO객체(e.g. SampleDto)를 만들어서 조회
    // @QueryProjection을 통해 생성한 DTO객체는 쿼리내에서 QClass를 사용해야 한다
    @Transactional(readOnly = true)
    fun findSampleVersion1(sampleId: Long): SampleDto =
        queryFactory
            .select(
                QSampleDto(
                    sample.name,
                    sample.id
                )
            )
            .from(sample)
            .where(sample.id.eq(sampleId))
            .fetchFirst()

    // Entity를 그대로 응답할때는 selectFrom() 사용
    @Transactional(readOnly = true)
    fun findSampleVersion2(sampleId: Long): Sample =
        queryFactory
            .selectFrom(sample)
            .where(sample.id.eq(sampleId))
            .fetchFirst()


    ////////////////////////////////////////////////////////////////////////////////////

    // insert, update, delete문은 쿼리가 성공한 개수를 Long 자료형으로 리턴한다.
    // 예를들어, 1개 데이터 insert하면 리턴값은 "1", 10개 데이터 insert하면 리턴값은 "10"
    @Transactional
    fun insertSample(sampleParam: Sample): Long =
        queryFactory
            .insert(sample)
            .columns(
                sample.name,
                sample.id
            )
            .values(
                sampleParam.name,
                sampleParam.id
            )
            .execute()

    @Transactional
    fun updateSample(id: Long, name: String): Long =
        queryFactory
            .update(sample)
            .set(sample.name, name)
            .where(sample.id.eq(id))
            .execute()

    @Transactional
    fun deleteSample(id: Long): Long =
        queryFactory
            .delete(sample)
            .where(sample.id.eq(id))
            .execute()
}