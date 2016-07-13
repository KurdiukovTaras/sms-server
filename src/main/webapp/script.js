jQuery('document').ready(function(){
//jQuery('body').append('<a href="http://www.google.ru">Go to link</a>');
//jQuery('div').remove();
//var p_clon;
//p_clon=jQuery('p').clone();
//jQuery('body').append(p_clon);

//      jQuery('button').on('click',function(){
//
//        var value1,value2,value3;
//        value1=jQuery('#val1').val();
//        value2=jQuery('#val2').val();
//        value1=parseInt(value1);
//                value2=parseInt(value2);
//        value3=value1+value2;
//        alert(value3);
//      });
//   name=prompt('Write your name');
//     if (name!="admin")
//     {
//         alert("Bitch, get out of here!")
//     }


  jQuery('#rezult').html(name);

         jQuery('input').on('keyup',function(){
           value1=jQuery('#val1').val();
           value2=jQuery('#val2').val();
         jQuery('#rezult').html(value1+' '+value2);
         });


});

