package ddd.teople.cleanarchitecture.common.cache

import com.github.benmanes.caffeine.cache.Caffeine
import org.springframework.cache.CacheManager
import org.springframework.cache.caffeine.CaffeineCache
import org.springframework.cache.support.SimpleCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.TimeUnit

@Configuration
class CacheConfig {
    @Bean
    fun cacheManager(): CacheManager {
        val cacheManager = SimpleCacheManager()
        val caches = CacheType.values().map {
            CaffeineCache(
                it.cacheName,
                Caffeine.newBuilder()
                    .expireAfterWrite(it.expireAfterWrite, TimeUnit.SECONDS)
                    .maximumSize(it.maximumSize)
                    .build()
            )
        }
        cacheManager.setCaches(caches)
        return cacheManager
    }
}