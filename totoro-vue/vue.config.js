module.exports = {
    /**
     * 接口代理配置
     * 如果你的前端应用和后端 API 服务器没有运行在同一个主机上，你需要在开发环境下将 API 请求代理到 API 服务器。
     * https://cli.vuejs.org/zh/config/#devserver-proxy
     * https://github.com/chimurai/http-proxy-middleware#proxycontext-config
     */
    devServer: {
        disableHostCheck: true
    },
}