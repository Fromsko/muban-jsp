// axios 封装
function createClient(baseURL) {
    const axiosInstance = axios.create({
        baseURL: baseURL, timeout: 5000, // 设置请求超时时间
        headers: {
            'Content-Type': 'application/json'
        }
    })

    // 通用 GET 请求封装
    const get = async (url) => {
        try {
            const response = await axiosInstance.get(url)
            return response.data
        } catch (error) {
            console.error('GET 请求失败:', error)
            throw error
        }
    }

    // 通用 POST 请求封装
    const post = async (url, data) => {
        try {
            const response = await axiosInstance.post(url, data)
            return response.data
        } catch (error) {
            console.error('POST 请求失败:', error)
            throw error
        }
    }

    return {
        get, post
    }
}

// 客户端方法
let useWebClient = () => {
    // 使用 baseURL 创建请求客户端
    const authClient = () => {
        const client = createClient('/api/auth')

        const sigIn = async (credentials) => {
            return await client.post('/sign-in', credentials)
        }

        const sigUp = async (credentials) => {
            return await client.post('/sign-up', credentials)
        }

        const sigOut = async () => {
            await client.get('/sign-out')
        }

        return {
            sigIn, sigUp, sigOut
        }
    }

    const totalClient = () => {
        const client = createClient('/api/guard')

        const getTotal = async () => {
            return await client.get('/getTotal')
        }

        const getRoutes = async () => {
            let pagesData = await client.get('/getRoutes')
            return Object.entries(pagesData).map(([path, view]) => `
                    <div class="card bg-gradient-to-r from-cyan-500 to-blue-500 space-y-2 text-black shadow-xl hover:shadow-lg transition-shadow duration-300">
                        <div class="card-body p-2">
                            <a href="${path}" class="block text-lg font-bold" target="_blank">${path}</a>
                        </div>
                    </div>
                `).join('');
        }

        return {
            getTotal, getRoutes
        }
    }

    return {
        authClient, totalClient
    }
}
