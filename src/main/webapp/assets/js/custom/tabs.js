// Add click event handler to each tab
tabs.on('click', function () {
  // Remove active class from all tabs
  tabs.removeClass('tab-active')

  // Add active class to clicked tab
  $(this).addClass('tab-active')

  // Here you can add logic to show/hide corresponding content
  // const tabIndex = $(this).index();
  // $('.tab-content').hide();
  // $(`.tab-content[data-tab="${tabIndex}"]`).show();
})
