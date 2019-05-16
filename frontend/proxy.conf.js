const PROXY_CONFIG = [
    {
        context: [
            "/api",
            "/somethingelse"
        ],
        target: "http://localhost:8080",
        secure: false
    }
]

module.exports = PROXY_CONFIG;