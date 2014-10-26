$(function() {
    $.get('/listRates')
        .done(function(data) {
            var predicateMale = function(input) {
                return input.gender === "male";
            };
            var appendToTable = function(tableName) {
                return function(index, element) {
                    $("#"+tableName+" > tbody:last")
                        .append("<tr><td>"+element.zipBase+"</td><td>"+element.rate0+"</td><td>"+element.rate20+"</td><td>"+element.rate30+"</td><td>"+element.rate40+"</td><td>"+element.rate50+"</td><td>"+element.rate60+"</td><td>"+element.rate70+"</td></tr>");
                };
            };

            var maleRates = $.grep(data, predicateMale);
            var femaleRates = $.grep(data, predicateMale, true);

            $.each(maleRates, appendToTable("maleRates"));
            $.each(femaleRates, appendToTable("femaleRates"));

        });
});
