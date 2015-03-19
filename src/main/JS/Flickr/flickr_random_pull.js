$(function () {
    var animalChoices = ['owl', 'otter', 'alpaca', 'frog', 'cat'];
    var animalSearch = animalChoices[getRandomInt(0, animalChoices.length)];
    //cambio il titolo della pagina, mettendo il nome dell'animale con la prima lettera maiuscola
    document.title = animalSearch[0].toUpperCase() + animalSearch.slice(1) + ' Flikr Demo';
    var urlForAPI = 'https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=6902943f0a9e5a3d4e84475e392ca8e7&format=json&nojsoncallback=1&sort=relevance&text=' + animalSearch;
    $.getJSON(urlForAPI,
        function (data) {
            var maxRandInt = data.photos.perpage; //il numero degli elementi massimo, attualmente perpage=100 (default)
            var randInt = getRandomInt(0, maxRandInt);
            console.log(maxRandInt);
            console.log(randInt);
            $.each(data.photos.photo, function (i, item) {

                if (i === randInt) {
                    var photoDimension = 'z';
                    var photoURL = 'http://farm' + item.farm + '.static.flickr.com/' + item.server + '/' + item.id + '_' + item.secret + '_' + photoDimension + '.jpg';
                    $('#images').text(' ');
                    $("<img>").attr({
                        src: photoURL,
                        'class': '.displayed',
                        alt: item.title,
                        title: item.title
                    }).appendTo("#images");
                    $('<a>').attr({
                        href: "http://www.flickr.com/photos/" + item.owner + "/" + item.id,
                        id: 'link-text'
                    }).appendTo('#text');
                    $('a#link-text').text('Link to original photo on Flickr');
                    return false;
                }
            });
        }
    );
});
function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min)) + min;
}