$('.view-option').on('click','li',function(){
    $('.view-option li').removeClass('txt-bold');
    $(this).addClass('txt-bold');
})


$('.goback').on('click',function(e){
    e.preventDefault();
    history.back();
})

$('.list-option').on('click','li',function(){
    $('.list-option li').removeClass('active');
    $(this).addClass('active');
})

/*$('.heart').on('click',function(e){
    e.preventDefault();
    $(this).toggleClass('heart-full');
})*/

$('.search-container input').on('keyup',function(e){
    if (e.which == 13) {
        if (!$(this).val()) {
            location.href = 'http://13.125.232.126/gerion/search-empty.html';
        }else{
            location.href = 'http://13.125.232.126/gerion/search-result.html';
        }
    }
})
$('.option-box a').on('click',function(){
    $('.option-box a').removeClass('active')
    $(this).addClass('active');
})

$('.btn-sort').on('click',function(){
    $('.for-sort').addClass('active');
})
$('.for-sort .sort-option a').on('click',function(){
    $('.for-sort .sort-option a').removeClass('checked');
    $(this).addClass('checked');
    $('.for-sort').removeClass('active');
})

$('.cactegory-list-container li').on('click',function(){
    if($(this).hasClass('selected')){
        $(this).removeClass('selected')
    }else{
        $(this).addClass('selected')
    }
})

$('.company-views li').on('click',function(){
    $('.company-views li').removeClass('active');
    $(this).addClass('active');
})

$(document).on('click','.keyword-add',function(e){
    e.preventDefault();
    var keyword = $('.input-box input')
    console.log(keyword);
    if(keyword.val()){
        var tag = '<li><a href="#">'+keyword.val()+'</a></li>'
        $('.keywords-box ul').append(tag);
        keyword.val('');
    }

})

$(document).on('click','.keywords-box ul li',function(e){
    $(this).remove();
})

$('.modal-holder').on('click','.btn-confirm',function(){
    $('.modal-holder').removeClass('active');
})


// recommended portfolio
$('.circle').each(function(){
	var idholder = '#'+$(this).attr('id');
    var color = $(this).data('color');
    var value= $(this).data('value') / 100;
    var colordef = color.toString();
    var bar = new ProgressBar.Circle(idholder, {
    color:'#333333',
    // This has to be the same size as the maximum width to
    // prevent clipping
    strokeWidth: 6,
    trailWidth: 6,
    trailColor: '#eaeaea',
    easing: 'easeInOut',
    duration: 1400,
    text: {
        autoStyleContainer: false
    },
    from: { color: colordef, width: 6 },
    to: { color: colordef, width: 6 },
    // Set default step function for all animate calls
    step: function(state, circle) {
        circle.path.setAttribute('stroke', state.color);
        circle.path.setAttribute('stroke-width', state.width);

        var value = Math.round(circle.value() * 100);
        if (value === 0) {
        circle.setText('');
        } else {
        circle.setText(value);
        }

    }
    });

    bar.animate(value);
    });
// Number from 0.0 to 1.0


$('.algorithm .bar-holder').each(function(){
    var width =$(this).data('width');
    $(this).find('span').animate({
        'width':width+"px"
    });
})

// recommended portfolio


// swing market view events
$('.view-events a').on('click',function(e){
    e.preventDefault();
    $(this).parents().eq(2).find('.clearfix').toggleClass('active');
    $(this).find('.sign').toggleClass('active');
})
// swing market view events