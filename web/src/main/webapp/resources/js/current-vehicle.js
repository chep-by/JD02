function rentCost() {
var dateTakeString = $('#dateTakepicker3').val();
var dateReturnString = $('#dateReturnpicker3').val();

var dateTake = new Date(dateTakeString);
var dateReturn = new Date(dateReturnString);

var oneDay = 24*60*60*1000;
var diffDays = Math.round(Math.abs((dateReturn.getTime() - dateTake.getTime())/(oneDay)));

console.log(diffDays);

    var tbl = $('table#costTable tr:has(td)').map(function(i, v) {
        var $td =  $('td', this)
        return {
            strategy: $td.eq(0).text(),
            cost: $td.eq(1).text(),
        }
    }).get();

    console.log(tbl)


}