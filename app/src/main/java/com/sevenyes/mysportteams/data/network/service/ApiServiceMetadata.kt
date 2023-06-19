package com.sevenyes.mysportteams.data.network.service

import com.sevenyes.mysportteams.BuildConfig
import javax.inject.Inject

interface ApiServiceMetadata {
    fun getApiKey(): String
    fun getBaseUrl(): String
}

/**
 * This class is used for simplicity, in a real world app this
 * values might be coming from the UNIX env or even better some
 * remote config service e.g LaunchDarkly, Firebase, etc.
 */
class GradlePropertiesApiKeyServiceImpl @Inject constructor(): ApiServiceMetadata {
    override fun getApiKey(): String = BuildConfig.API_KEY
    override fun getBaseUrl(): String = BuildConfig.API_BASE_URL
}