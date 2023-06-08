/*약속목록 정렬 체크박스 중복방지*/
function NoMultiChk(chk){
    var obj = document.getElementsByName("sort_what_close");
     for(var i=0; i<obj.length; i++){
       if(obj[i] != chk){
         obj[i].checked = false;
       }
     }
}

/* 아래는 지도 예정 */