$(function() {
    $.get('/listRates')
        .done(function(data) {
            var predicateMale = function(input) {
                return input.gender === "male";
            };
            var appendToTable = function(gender) {
                return function(index, element) {
                    $("#"+gender+"Rates > tbody:last")
                        .append("<tr>"+
                            "<td>"+element.zipBase+"</td>"+
                            "<td>"+element.rate0+"</td>"+
                            "<td>"+element.rate20+"</td>"+
                            "<td>"+element.rate30+"</td>"+
                            "<td>"+element.rate40+"</td>"+
                            "<td>"+element.rate50+"</td>"+
                            "<td>"+element.rate60+"</td>"+
                            "<td>"+element.rate70+"</td>"+
                            "<td>" + "<a href='/deleteRate/" + element.id + "'>Delete</a>" + "</td>"+
                            "</tr>");
                };
            };

            var maleRates = $.grep(data, predicateMale);
            var femaleRates = $.grep(data, predicateMale, true);

            $.each(maleRates, appendToTable("male"));
            $.each(femaleRates, appendToTable("female"));

        });
});
