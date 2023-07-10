
/*<![CDATA[*/

$(document).ready(function(){

    //목록 버튼 클릭 시
   $("#list_button").click(function(){
    if($(".sub_category_ment").text()=='카체'){
            location.href = '/appointment/activityList/cafe';
    }else if($(".sub_category_ment").text()=='맛집'){
            location.href = '/appointment/activityList/restaurant';
    }else if($(".sub_category_ment").text()=='스포츠'){
            location.href = '/appointment/activityList/sport';
    }else if($(".sub_category_ment").text()=='야외활동'){
            location.href = '/appointment/activityList/outdoor';
    }else if($(".sub_category_ment").text()=='구매'){
            location.href = '/appointment/activityList/buy';
    }else if($(".sub_category_ment").text()=='게임'){
            location.href = '/appointment/activityList/game';
    }else if($(".sub_category_ment").text()=='기타'){
            location.href = '/appointment/activityList/others';
    }


   });

    var seqVal = [[$("#delete_button").val()]];
    var seq = parseInt(seqVal);
    console.log(seq);

    //삭제 버튼 클릭 시
    $("#delete_button").click(function(){
        //참여자 수를 체크
        //if($(".participant_member_nick").val()==0){
            //삭제 시 확인창 띄우기
            var keepDelete;
            keepDelete = confirm( '정말 삭제하시겠습니까?' );
            if(keepDelete){
                location.replace('/appointment/deleteActivity?appo_seq=' + seq);
            }
        //}else{
            //alert('참여하는 사람이 있어 삭제할 수 없습니다.');
        //}
    });

});

var map;
var service;
var infowindow;
function initMap(){
    //약속장소 변수 값을 받아오기
    var appo_place = $("#google_map").data('placevalue');
    console.log("저장된 장소 : " + appo_place);

    //현재 위치 정보를 받아와서 Google Maps API에 위치 매개변수를 설정하기
    var lat, lng; // latitude, longitude (위도, 경도)
    lat = 37.548196; lng = 127.073186; // 유저 위치로 교체 예정
    var initlocation = new google.maps.LatLng(lat, lng);
    infowindow = new google.maps.InfoWindow(); //지정된 위치의 팝업 창에 콘텐츠(보통 텍스트나 이미지)를 표시

    //현재 위치를 중심으로 설정하기
    map = new google.maps.Map(document.getElementById('google_map'), {
        center: initlocation,
        zoom: 17,
        mapTypeControl : false,
        streetViewControl : false
        });


    //google maps 검색을 위한 요청문
    var request = {
        // 검색 쿼리 설정
        query: appo_place,
        // 검색 옵션 설정 (옵션이 없는 경우 생략 가능)
        fields: ['name', 'formatted_address', 'geometry', 'place_id']
    };

    //Google Maps API에서 Places 서비스를 초기화
    var service = new google.maps.places.PlacesService(map); //findPlaceFromQuery를 사용하여 정보를 요청하는 함수
    service.findPlaceFromQuery(request, function(results, status) {
        //console.log(results);

        if (status === google.maps.places.PlacesServiceStatus.OK) {
            createMarker(results[0]);
            map.setCenter(results[0].geometry.location);
            console.log("장소 이름 : " + results[0].name);
            console.log("주소 : " + results[0].formatted_address);
            console.log("위치 : " + results[0].geometry.location);
            console.log("장소ID : " + results[0].place_id);
        }

    });


}
    //마커 생성 함수
    function createMarker(place) {
        new google.maps.Marker({
            position: place.geometry.location,
            map: map
        });
    }

/*]]>*/

