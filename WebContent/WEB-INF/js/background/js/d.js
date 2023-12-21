$(function() {
    $("a.polaroid").each(function() {
        $(this).css({
            "-webkit-transform": 'rotate(' + (Math.floor(Math.random()*10)-5) + 'deg)',
            "-moz-transform": 'rotate(' + (Math.floor(Math.random()*10)-5) + 'deg)'
        })
        .hover(function() {
            $(this).css({
                "-webkit-transform": 'rotate(' + (Math.floor(Math.random()*10)-5) + 'deg) scale(1.05)',
                "-moz-transform": 'rotate(' + (Math.floor(Math.random()*10)-5) + 'deg) scale(1.05)'
            })
        }, function() {
            $(this).css({
                "-webkit-transform": 'rotate(' + (Math.floor(Math.random()*10)-5) + 'deg) scale(1)',
                "-moz-transform": 'rotate(' + (Math.floor(Math.random()*10)-5) + 'deg) scale(1)'
            })
        });
    });
    $('a[rel=lightbox]').fancyZoom();
});
