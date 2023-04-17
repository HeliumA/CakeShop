const base = {
    get() {
                return {
            url : "http://localhost:8080/CakeShop/",
            name: "CakeShop",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/CakeShop/front/index.html'
        };
            },
    getProjectName(){
        return {
            projectName: "蛋糕店网上选购系统"
        } 
    }
}
export default base
