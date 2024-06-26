document.addEventListener('DOMContentLoaded', function() {
    var closeButtons = document.querySelectorAll('.alert .close');

    closeButtons.forEach(function(button) {
        button.addEventListener('click', function(event) {
            var alert = event.target.closest('.alert');
            alert.style.display = 'none';
        });
    });
});