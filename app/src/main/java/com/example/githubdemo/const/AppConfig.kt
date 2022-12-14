package com.example.githubdemo.const

class AppConfig {
    companion object{

        const val TOKEN = "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"

        const val GITHUB_BASE_URL = "https://github.com/"

        const val GITHUB_API_BASE_URL = "https://api.github.com/"

        const val HTTP_TIME_OUT = 32 * 1000

        val OPENHUB_CLIENT_ID: String = "8f7213694e115df205fb"


        const val OAUTH2_SCOPE = "user,repo,gist,notifications"


        const val OAUTH2_URL = GITHUB_BASE_URL + "login/oauth/authorize"

    }
}