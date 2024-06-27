document.addEventListener('DOMContentLoaded', function() {
    const radioForm = document.getElementById('radioForm');
    const validateButton = document.getElementById('validateButton');

    radioForm.addEventListener('change', function() {
        const isRadioChecked = Array.from(radioForm.elements['option']).some(radio => radio.checked);
        validateButton.disabled = !isRadioChecked;
    });

    validateButton.addEventListener('click', function() {
        if (!validateButton.disabled) {
            alert('Compra bem sucedida!');s
        }
    });
});
