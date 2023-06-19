document.addEventListener('DOMContentLoaded', function() {
    var passwordConfirmInput = document.getElementById('password_confirm');
    var passwordInput = document.getElementById('password');
    var passwordError = document.getElementById('password_error');

    passwordConfirmInput.addEventListener('keyup', function() {
        var password = passwordInput.value;
        var passwordConfirm = this.value;

        if (password !== passwordConfirm) {
            passwordError.textContent = '비밀번호가 일치하지 않습니다.';
            passwordError.style.color = 'red';
        } else {
            passwordError.textContent = '비밀번호가 일치합니다.';
            passwordError.style.color = 'green';
        }
    });
});

function updateEmailDomain() {
    var selectBox = document.getElementById("emailDomainSelect");
    var emailDomainInput = document.getElementById("emailDomain");
    var selectedDomain = selectBox.value;

    if (selectedDomain === "직접입력") {
        emailDomainInput.value = "";
        emailDomainInput.disabled = false;
    } else {
        emailDomainInput.value = selectedDomain;
        emailDomainInput.disabled = true;
    }
}