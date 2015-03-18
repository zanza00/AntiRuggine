

$(function () {
    var animalSearch = 'owl';
    var urlForAPI = 'https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=6902943f0a9e5a3d4e84475e392ca8e7&format=json&nojsoncallback=1&sort=relevance&text=' + animalSearch;
    $.getJSON(urlForAPI + animalSearch,
        function (data) {
            var maxRandInt = data.photos.total; //il numero degli elementi massimo
            $.each(data.photos.photo, function (i, item) {
                var randInt = getRandomInt(0, maxRandInt);

                if (i === randInt) {
                    var photoDimension = 'm';
                    var photoURL = 'http://farm' + item.farm + '.static.flickr.com/' + item.server + '/' + item.id + '_' + item.secret + '_' + photoDimension + '.jpg';
                    $("<img>").attr("src", photoURL).appendTo("#images");
                    return false;
                }
            });
        }
    );
});
function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min)) + min;
}