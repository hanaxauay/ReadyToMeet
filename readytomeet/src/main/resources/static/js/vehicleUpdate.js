/*날짜 라디오 버튼 클릭 시*/
//function showTimeOption(chk) {
//    document.getElementById("selected_choosetime").style.display = "block";
//}

//  /*[[]]*/


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

    //검색 버튼 클릭 시
        $("#search_icon1").click(function() {
            marker1.setMap(null);
            var changePlace = $("input[name='appo_start_place']").val();
            console.log("새로 저장된 출발장소 : " + changePlace);

            //google maps 검색을 위한 요청문
            var request = {
            // 검색 쿼리 설정
            query: changePlace,
            // 검색 옵션 설정 (옵션이 없는 경우 생략 가능)
            fields: ['name', 'formatted_address', 'geometry', 'place_id']
            };

            var service = new google.maps.places.PlacesService(map1);
            service.findPlaceFromQuery(request, function(results, status) {
                //console.log(results);

                if (status === google.maps.places.PlacesServiceStatus.OK) {
                    createMarker1(results[0]);
                    map1.setCenter(results[0].geometry.location);
                    console.log("새 출발장소 이름 : " + results[0].name);
                    console.log("새 출발주소 : " + results[0].formatted_address);
                    console.log("새 출발위치 : " + results[0].geometry.location);
                    console.log("새 출발장소ID : " + results[0].place_id);
                }

            });
        });
        $("#search_icon2").click(function() {
                    marker2.setMap(null);
                    var changePlace = $("input[name='appo_place']").val();
                    console.log("새로 저장된 도착장소 : " + changePlace);

                    //google maps 검색을 위한 요청문
                    var request = {
                    // 검색 쿼리 설정
                    query: changePlace,
                    // 검색 옵션 설정 (옵션이 없는 경우 생략 가능)
                    fields: ['name', 'formatted_address', 'geometry', 'place_id']
                    };

                    var service = new google.maps.places.PlacesService(map2);
                    service.findPlaceFromQuery(request, function(results, status) {
                        //console.log(results);

                        if (status === google.maps.places.PlacesServiceStatus.OK) {
                            createMarker2(results[0]);
                            map2.setCenter(results[0].geometry.location);
                            console.log("새 도착장소 이름 : " + results[0].name);
                            console.log("새 도착주소 : " + results[0].formatted_address);
                            console.log("새 도착위치 : " + results[0].geometry.location);
                            console.log("새 도착장소ID : " + results[0].place_id);
                        }

                    });
                });
});

//시간 변동 없을 시 기존 값 넘기기
function timeSubmit(){
    var date1 = $("input[name='appo_date1']").val();
    var date2 = $("input[name='appo_date2']").val();

    var strTime = date1 + ' ' + date2 + ':00';
    console.log(strTime);
    [[$("input[name='appo_time']").val(strTime)]];
    //return false;
}

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
    marker1 = new google.maps.Marker({
        position: place.geometry.location,
        map: map1
    });
}
function createMarker2(place) {
    marker2 = new google.maps.Marker({
        position: place.geometry.location,
        map: map2
    });
}

/*]]>*/