package com.example.githubdemo.const

class AppConfig {
    companion object{

        const val GITHUB_BASE_URL = "https://github.com/"

        const val GITHUB_API_BASE_URL = "https://api.github.com/"

        const val HTTP_TIME_OUT = 32 * 1000

        const val HTTP_MAX_CACHE_SIZE = 32 * 1024 * 1024

        val OPENHUB_CLIENT_ID: String = "8f7213694e115df205fb"

        val OPENHUB_CLIENT_SECRET: String = "82c57672382db5c7b528d79e283c398ad02e3c3f"

        const val OAUTH2_SCOPE = "user,repo,gist,notifications"


        const val OAUTH2_URL = GITHUB_BASE_URL + "login/oauth/authorize"

    }
}