package ddd.teople.cleanarchitecture.sample.adapter.out.persistencce.dto

import com.querydsl.core.annotations.QueryProjection

// @QueryProjection은 조회할 쿼리의 자료형을 정의한다.
// @QueryProjection 붙은 클래스도 QClass가 생긴다
data class SampleDto @QueryProjection constructor(
    val name: String? = null,
    val id: Long? = null
)