document.addEventListener('DOMContentLoaded', function() {
    var password = document.getElementById('password');
    var passwordConfirm = document.getElementById('password_confirm');
    var passwordError = document.getElementById('password_error');

    passwordConfirm.addEventListener('keyup', function() {
        if (password.value !== passwordConfirm.value) {
            passwordError.textContent = '비밀번호가 일치하지 않습니다.';
            passwordError.style.color = 'red';
            document.getElementById('pwDoubleChk').value = 'false';
        } else {
            passwordError.textContent = '비밀번호가 일치합니다.';
            passwordError.style.color = 'green';
            document.getElementById('pwDoubleChk').value = 'true';
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

document.addEventListener('DOMContentLoaded', function() {
    var phoneChk = document.getElementById('phoneChk');
    var phone = document.getElementById('phone');
    var successPhoneChk = document.querySelector('.successPhoneChk');
    var phone2 = document.getElementById('phone2');
    var phoneChk2 = document.getElementById('phoneChk2');
    var code2;

    phoneChk.addEventListener('click', function() {
        alert('인증번호 발송이 완료되었습니다.\n휴대폰에서 인증번호 확인을 해주십시오.');
        var phoneValue = phone.value;
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4 && xhr.status === 200) {
                var data = xhr.responseText;
                if (data === 'error') {
                    alert('휴대폰 번호가 올바르지 않습니다.');
                    successPhoneChk.textContent = '유효한 번호를 입력해주세요.';
                    successPhoneChk.style.color = 'red';
                    phone.focus();
                } else {
                    phone2.disabled = false;
                    phoneChk2.style.display = 'inline';
                    successPhoneChk.textContent = '인증번호를 입력한 뒤 본인인증을 눌러주십시오.';
                    successPhoneChk.style.color = 'green';
                    phone.readOnly = true;
                    code2 = data;
                }
            }
        };
        xhr.open('GET', 'phoneCheck?phone=' + phoneValue, true);
        xhr.send();
    });

    phoneChk2.addEventListener('click', function() {
        if (phone2.value === code2) {
            successPhoneChk.textContent = '인증번호가 일치합니다.';
            successPhoneChk.style.color = 'green';
            document.getElementById('phoneDoubleChk').value = 'true';
            phone2.disabled = true;
        } else {
            successPhoneChk.textContent = '인증번호가 일치하지 않습니다. 확인해주시기 바랍니다.';
            successPhoneChk.style.color = 'red';
            document.getElementById('phoneDoubleChk').value = 'false';
            phone2.focus();
        }
    });
});
