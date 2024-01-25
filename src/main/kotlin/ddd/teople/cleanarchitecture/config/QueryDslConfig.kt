package ddd.teople.cleanarchitecture.config

import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class QueryDslConfig {

    // @PersistenceContext는 EntityManager를 빈으로 주입할때 사용하는 어노테이션
    // 실제 MySqlConfig와 QueryDslConfig가 별도의 클래스로 설정하는 경우가 많은데, MySqlConfig에 설정된 EntityManager Bean을 QueryDslConfig에서 사용하기 위해 Bean주입
    @PersistenceContext(unitName = "teopleTransactionManager")
    lateinit var teopleEntityManager: EntityManager

    @Bean
    fun teopleQueryFactory() =
        JPAQueryFactory(teopleEntityManager)
}