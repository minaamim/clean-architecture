package ddd.teople.cleanarchitecture.common.config


enum class CacheType(var cacheName: String, val expireAfterWrite: Long, val maximumSize: Long) {
    ELEMENTS(
        "cacheElements", // 캐시 이름
        60 * 60, // 캐시가 write 된 시점으로부터 만료 시간(초 단위)
        10 // 최대 사이즈
    )


}