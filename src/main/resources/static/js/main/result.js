console.log(myLocation);
console.log(yourLocation);
console.log(categories);
console.log(centerLocation);
console.log(poiData);
console.log(myRoute);
console.log(yourRoute);

let map = new naver.maps.Map('map', {
    center: new naver.maps.LatLng(centerLocation.y, centerLocation.x),
    zoom: 13
});
poiData.forEach(poi => {
    let marker = new naver.maps.Marker({
        position: new naver.maps.LatLng(poi.lat, poi.lon),
        map: map
    });
    let infoWindow = new naver.maps.InfoWindow({
        content: poi.name
    });
    /*
    naver.maps.Event.addListener(marker, 'click', function(e) {
        if (infoWindow.getMap()) {
            infoWindow.close();
        } else {
            infoWindow.open(map, marker);
        }
    });

     */
});