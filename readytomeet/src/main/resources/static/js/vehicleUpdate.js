/*<![CDATA[*/

$(document).ready(function(){

    // 날짜 라디오버튼 클릭 시
    $("input:radio[name=option_time]").click(function(){

        if($("input[name=option_time]:checked").val() == "choosetime"){
            // radio 버튼의 value 값이 choosetime 이라면 보이기
            $("#selected_choosetime").show();
        }else if($("input[name=option_time]:checked").val() == "allday"){
            // radio 버튼의 value 값이 allday이라면 비활성화
            $("#selected_choosetime").hide();
            var date1 = $("input[name='appo_date1']").val();
            var strTime = date1 + ' 00:00:00';
            [[$("input[name='appo_time']").val(strTime)]];
        }
    });

    //날짜 date1 + 시간 date2 값 합쳐서 hidden appo_time으로 보내기
    $(".add_time_value").change(function() {

        var date1 = $("input[name='appo_date1']").val();
        var date2 = $("input[name='appo_date2']").val();

        var strTime = date1 + ' ' + date2 + ':00';
        console.log(strTime);
        //strTime = Date.parse(strTime);

        [[$("input[name='appo_time']").val(strTime)]];
    });

});

/*]]>*/