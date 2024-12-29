(function ($) {
    $.fn.themeToggle = function () {
        return this.each(function () {
            const $this = $(this);
            const currentTheme = localStorage.getItem('theme') || 'light';
            document.documentElement.setAttribute('data-theme', currentTheme);
            $this.prop('checked', currentTheme === 'dark');

            $this.on('change', function () {
                const newTheme = this.checked ? 'dark' : 'light';
                document.documentElement.setAttribute('data-theme', newTheme);
                localStorage.setItem('theme', newTheme);
            });
        });
    };
})(jQuery);