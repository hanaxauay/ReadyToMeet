/*약속목록 정렬 체크박스 중복방지*/
function NoMultiChk(chk){
    var obj = document.getElementsByName("sort_what_close");
     for(var i=0; i<obj.length; i++){
       if(obj[i] != chk){
         obj[i].checked = false;
       }
     }
}

/* 아래는 터임리프 변수 사용 */

/*<![CDATA[*/

let compose = { lat: 37.548196, lng: 127.073186 };
// Google Places API 키 설정
const apiKey = 'AIzaSyAq6yoA_LB1nbECk64mZ3bRImbi1ZMmhCc';

function initMap(){

    //현재 위치 정보를 받아와서 Google Maps API에 위치 매개변수를 설정하기
    var location = new google.maps.LatLng(lat, lng);
    infowindow = new google.maps.InfoWindow(); //지정된 위치의 팝업 창에 콘텐츠(보통 텍스트나 이미지)를 표시

    //현재 위치를 중심으로 설정하기
    map = new google.maps.Map(
        document.getElementById('google_map'), {center: location, zoom: 15});


    //google maps 검색을 위한 요청문
    var request = {
        // 검색 쿼리 설정
        query: '군자동 스타벅스',
        // 검색 옵션 설정 (옵션이 없는 경우 생략 가능)
        fields: ['name', 'formatted_address', 'geometry', 'place_id']
    };

//    const { places } = await google.maps.places.Place.findPlaceFromQuery(request);
//
//      if (places.length) {
//        const place = places[0];
//        const location = place.location;
//        const markerView = new google.maps.marker.AdvancedMarkerView({
//          map,
//          position: place.location,
//          title: place.displayName,
//        });
//
//        map.setCenter(location);
//      } else {
//        console.log("No results");
//      }

//Google Maps API에서 Places 서비스를 초기화
    var service = new google.maps.places.PlacesService(map); //findPlaceFromQuery를 사용하여 정보를 요청하는 함수
    service.findPlaceFromQuery(request, function(results, status) {
        console.log(results);
        if (status === google.maps.places.PlacesServiceStatus.OK) {
//            for (var i = 0; i < results.length; i++) {
//                createMarker(results[i]);
//                console.log(results[i]);
//            }
            createMarker(results[0]);
            map.setCenter(results[0].geometry.location);
            console.log(results[0].name);
            console.log(results[0].formatted_address);
            console.log(results[0].geometry.location);
            console.log(results[0].place_id);

        }
    });


// }
}

//Create Marker
function createMarker(place) {
    new google.maps.Marker({
        position: place.geometry.location,
        map: map
    });
}




var lat, lng; // latitude, longitude (위도, 경도)


$(function(){
//google.maps.event.addDomListener(window, 'load', initialize);
});

//function searchPlace() {
//
//    if($("#google_map").length) {
//
//        /*---------지도 설정-----------*/
//        var mapOptions = { //구글 맵 옵션 설정
//            zoom : 15, //기본 확대율
//            // 지도 중앙 위치 -> 나중에 유저 위치로 바꿔야
//            center : new google.maps.LatLng(37.548196, 127.073186),
//            scrollwheel : true, //마우스 휠로 확대 축소 사용 여부
//            mapTypeControl : false //맵 타입 컨트롤 사용 여부
//        };
//
//        //위치 저장 변수
//        var location = new google.maps.LatLng(lat, lng);
//
//        //맵 생성
//        var map = new google.maps.Map(document.getElementById('google_map'), mapOptions);
//
//
//        /*---------마커 설정---------*/
//        var imageUrl = 'https://cheolguso.com/img/iconimg.png'; //마커 이미지 설정
//
//        var marker = new google.maps.Marker({ //마커 설정
//            map : map,
//            position : map.getCenter(), //마커 위치
//            icon: { //마커 이미지
//                url: imageUrl,  //"../../image/mypage.png",
//                labelOrigin: new google.maps.Point(100, 55)
//            }
//            label: {
//                text: "현위치",
//                color: "#ff7777"
//            }
//        });
//        google.maps.event.addDomListener(window, "resize", function() { //리사이즈에 따른 마커 위치
//            var center = map.getCenter();
//            google.maps.event.trigger(map, "resize");
//            map.setCenter(center);
//        });
//
//    }
//}





/*]]>*/