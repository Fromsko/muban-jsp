const useModalStore = function (params = {}) {
    // 默认参数
    const defaultParams = {
        headerLoginBtnId: 'header_login_btn',
        modalId: 'authModal', modalFormId: 'authForm',
        captchaId: 'modal_login_captcha', captchaImageId: 'modal_login_captchaImage',
        usernameId: 'modal_login_username', passwordId: 'modal_login_password',
        loginApiUrl: '/auth/login', captchaUrl: '/auth/checkCode',
        success: (data) => {
            console.log(data)
        },
        error: (err) => {
            console.error(err.response?.data?.message || err.message)
        }
    }

    // 合并默认参数与传入的参数
    params = {...defaultParams, ...params}

    // 延迟初始化 DOM 元素
    const modalElements = {
        modal: null,
        form: null,
        loginBtn: null,
        captcha: null,
        captchaImage: null,
        usernameInput: null,
        passwordInput: null,
        headerLoginBtn: null
    }

    // 获取 DOM 元素的函数
    const initElements = () => {
        modalElements.modal = $('#' + params.modalId)
        modalElements.form = $('#' + params.modalFormId)
        modalElements.loginBtn = $('#' + params.loginBtnId)
        modalElements.captcha = $('#' + params.captchaId)
        modalElements.captchaImage = $('#' + params.captchaImageId)
        modalElements.usernameInput = $('#' + params.usernameId)
        modalElements.passwordInput = $('#' + params.passwordId)
        modalElements.headerLoginBtn = $('#' + params.headerLoginBtnId)
    }

    // 生成验证码 URL
    const generateCaptchaUrl = () => `${params.captchaUrl}?t=${new Date().getTime()}`

    // 刷新验证码
    const reloadCaptcha = () => {
        modalElements.captchaImage.attr('src', generateCaptchaUrl())
    }

    // 获取表单数据
    const getFormData = () => {
        return {
            username: modalElements.usernameInput.val(),
            password: modalElements.passwordInput.val(),
            captcha: modalElements.captcha.val()
        }
    }

    // 处理表单提交
    const onFormSubmit = (event) => {
        event.preventDefault()
        const formData = getFormData()
        handleLogin(formData)
    }

    // 登录请求
    const handleLogin = (formData) => {
        $.ajax({
            url: params.loginApiUrl,
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(formData),
            success: params.success,
            error: params.error,
        })
    }

    // 设置事件监听
    const setupEvents = () => {
        modalElements.headerLoginBtn.on('click', openModal)
        modalElements.captchaImage.on('click', reloadCaptcha) // 点击验证码刷新
        modalElements.form.on('submit', onFormSubmit) // 表单提交
    }

    // Modal 开关控制
    const modalActions = {
        open: () => modalElements.modal[0].showModal(), close: () => modalElements.modal[0].close()
    }

    const setup = () => {
        initElements() // 初始化 DOM 元素
        setupEvents() // 绑定事件
    }

    // 打开登录框
    const openModal = () => {
        modalActions.open()
    }

    // 关闭登录框
    const closeModal = () => {
        modalActions.close()
    }

    // 返回 API
    return {
        setup, openModal, closeModal
    }
}
