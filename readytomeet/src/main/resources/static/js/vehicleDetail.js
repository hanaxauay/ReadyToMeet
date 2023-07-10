
/*<![CDATA[*/

$(document).ready(function(){

    //목록 버튼 클릭 시
   $("#list_button").click(function(){
    if($("#sub_category_ment").text()=='카풀'){
            location.href = '/appointment/vehicleList/carpool';
    }else if($("#sub_category_ment").text()=='택시'){
            location.href = '/appointment/vehicleList/taxi';
    }
   });

    //삭제 버튼 클릭 시
    $("#delete_button").click(function(){

        var seqVal = [[$("#delete_button").val()]];
        var seq = parseInt(seqVal);

        //참여자 수를 체크
        //if($(".participant_member_nick").val()==0){
            //삭제 시 확인창 띄우기
            var keepDelete;
            keepDelete = confirm( '정말 삭제하시겠습니까?' );
            if(keepDelete){
                    location.replace('/appointment/deleteVehicle?appo_seq=' + seq);
            }
        //}else{
            //alert('참여하는 사람이 있어 삭제할 수 없습니다.');
        //}
    });

});

//구글 맵 생성
var map1;
var service1;
var map2;
var service2;
var infowindow;
function initMap(){
    //약속장소 변수 값을 받아오기
    var appo_start_place = $("#google_map1").data('placevalue1');
    console.log("저장된 출발장소 : " + appo_start_place);
    var appo_place = $("#google_map2").data('placevalue2');
        console.log("저장된 도착장소 : " + appo_place);

    //현재 위치 정보를 받아와서 Google Maps API에 위치 매개변수를 설정하기
    var lat, lng; // latitude, longitude (위도, 경도)
    lat = 37.548196; lng = 127.073186; // 유저 위치로 교체 필요
    var initlocation = new google.maps.LatLng(lat, lng);
    infowindow = new google.maps.InfoWindow(); //지정된 위치의 팝업 창에 콘텐츠(보통 텍스트나 이미지)를 표시

    //현재 위치를 중심으로 설정하기
    map1 = new google.maps.Map(document.getElementById('google_map1'), {
        center: initlocation,
        zoom: 17,
        mapTypeControl : false,
        streetViewControl : false
        });
    map2 = new google.maps.Map(document.getElementById('google_map2'), {
        center: initlocation,
        zoom: 17,
        mapTypeControl : false,
        streetViewControl : false
        });

    //google maps 검색을 위한 요청문
    var request1 = {
        // 검색 쿼리 설정
        query: appo_start_place,
        // 검색 옵션 설정 (옵션이 없는 경우 생략 가능)
        fields: ['name', 'formatted_address', 'geometry', 'place_id']
    };
    var request2 = {
            // 검색 쿼리 설정
            query: appo_place,
            // 검색 옵션 설정 (옵션이 없는 경우 생략 가능)
            fields: ['name', 'formatted_address', 'geometry', 'place_id']
        };

    //appo_start_place 맵
    var service1 = new google.maps.places.PlacesService(map1); //findPlaceFromQuery를 사용하여 정보를 요청하는 함수
    service1.findPlaceFromQuery(request1, function(results, status) {
        console.log(results);
        if (status === google.maps.places.PlacesServiceStatus.OK) {
            createMarker1(results[0]);
            map1.setCenter(results[0].geometry.location);
            console.log("출발장소 이름 : " + results[0].name);
            console.log("출발주소 : " + results[0].formatted_address);
            console.log("출발위치 : " + results[0].geometry.location);
            console.log("출발장소ID : " + results[0].place_id);
        }
    });
    //appo_place 맵
        var service2 = new google.maps.places.PlacesService(map2); //findPlaceFromQuery를 사용하여 정보를 요청하는 함수
        service2.findPlaceFromQuery(request2, function(results, status) {
            console.log(results);
            if (status === google.maps.places.PlacesServiceStatus.OK) {
                createMarker2(results[0]);
                map2.setCenter(results[0].geometry.location);
                console.log("도착장소 이름 : " + results[0].name);
                console.log("도착주소 : " + results[0].formatted_address);
                console.log("도착위치 : " + results[0].geometry.location);
                console.log("도착장소ID : " + results[0].place_id);
            }
        });

}
    //마커 생성 함수
    function createMarker1(place) {
        new google.maps.Marker({
            position: place.geometry.location,
            map: map1
        });
    }
        function createMarker2(place) {
            new google.maps.Marker({
                position: place.geometry.location,
                map: map2
            });
        }

/*]]>*/

