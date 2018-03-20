$( document ).ready(function() {
    $('#dateTakepicker3').datetimepicker({
        locale: 'ru',
        format: 'DD.MM.YYYY',
        minDate: new Date()
    });
    $('#dateReturnpicker3').datetimepicker({
        locale: 'ru',
        format: 'DD.MM.YYYY',
        minDate: new Date()
    });
    var data = $('#vehicleId').val();
    $.ajax({
        url: '/reservationdates',
        data: {
            vehicleId: data,
            _csrf: $("input[name='_csrf']").val()
        }
        /*JSON.stringify(data)*/,
        method: 'post',
        success:(function (result) {
            result.forEach(function (value) {
                var startDate = new Date(value.startDate.year, value.startDate.monthValue-1, value.startDate.dayOfMonth);
                var endDate = new Date(value.endDate.year, value.endDate.monthValue-1, value.endDate.dayOfMonth);
                // var fromDate = moment({GGGG: value.startDate.year, MM: value.startDate.monthValue, DD: value.startDate.dayOfMonth});
                // var toDate =  moment({GGGG: value.endDate.year, MM: value.endDate.monthValue, DD: value.endDate.dayOfMonth });
                var array = getDatesArray(startDate, endDate)

                // var range = moment().range(fromDate, toDate);
                // var array = range.toArray('days');
                //
                // var readyarray = [];
                // $.each(array, function(e) {
                //     readyarray.push(moment(e).format("DD.MM.YYYY"));
                // });
                $('#dateTakepicker3').data("DateTimePicker").disabledDates(array);
                $('#dateReturnpicker3').data("DateTimePicker").disabledDates(array);

                // $('#dateTakepicker3').data("DateTimePicker").disabledTimeIntervals([
                //     [moment().year(value.startDate.year).month(value.startDate.monthValue-1).date(value.startDate.dayOfMonth), moment().year(value.endDate.year).month(value.endDate.monthValue-1).date(value.endDate.dayOfMonth)]
                // ]);
                // $('#dateTakepicker3').data("DateTimePicker").disabledTimeIntervals([
                //     [moment({GGGG: value.startDate.year, MM: value.startDate.monthValue, DD: value.startDate.dayOfMonth}), moment({GGGG: value.endDate.year, MM: value.endDate.monthValue, DD: value.endDate.dayOfMonth })]
                // ]);
                // $('#dateReturnpicker3').data("DateTimePicker").disabledTimeIntervals([
                //     [moment().year(value.startDate.year).month(value.startDate.monthValue-1).date(value.startDate.dayOfMonth), moment().year(value.endDate.year).month(value.endDate.monthValue-1).date(value.endDate.dayOfMonth)]
                // ])
            });
            console.log(result);
            // $('#dateTakepicker3').data("DateTimePicker").disabledDates(['17.03.2018','21.03.2018', '23.03.2018']);
            // $('#dateReturnpicker3').data("DateTimePicker").disabledDates(['17.03.2018','21.03.2018', '23.03.2018']);
        }),
        error:(function (result) {
            console.log(result)
        })
        // contentType: 'application/json'
    })
    // $('#dateTakepicker3').data("DateTimePicker").disabledDates(['17.03.2018','21.03.2018', '23.03.2018']);
    // $('#dateReturnpicker3').data("DateTimePicker").disabledDates(['17.03.2018','21.03.2018', '23.03.2018']);

});

function getDatesArray (startDate, endDate) {
    var dates = [],
        currentDate = startDate,
        addDays = function(days) {
            var date = new Date(this.valueOf());
            date.setDate(date.getDate() + days);
            return date;
        };
    while (currentDate <= endDate) {
        dates.push(currentDate);
        currentDate = addDays.call(currentDate, 1);
    }
    return dates;
};

function blockDates() {
    var data = $('#vehicleId').val();
    $.ajax({
        url: '/reservationdates',
        data: {
            vehicleId: data,
            _csrf: $("input[name='_csrf']").val()
        }
        /*JSON.stringify(data)*/,
        method: 'post',
        success:(function (result) {
            result.forEach(function (value) {
                // $('#dateTakepicker3').data("DateTimePicker").disabledTimeIntervals([
                //     [moment().year(value.startDate.year).month(value.startDate.monthValue-1).date(value.startDate.dayOfMonth), moment().year(value.endDate.year).month(value.endDate.monthValue-1).date(value.endDate.dayOfMonth)]
                // ]);
                $('#dateTakepicker3').data("DateTimePicker").disabledTimeIntervals([
                    [moment({GGGG: value.startDate.year, MM: value.startDate.monthValue, DD: value.startDate.dayOfMonth}), moment({GGGG: value.endDate.year, MM: value.endDate.monthValue, DD: value.endDate.dayOfMonth })]
                ]);
                $('#dateReturnpicker3').data("DateTimePicker").disabledTimeIntervals([
                    [moment().year(value.startDate.year).month(value.startDate.monthValue-1).date(value.startDate.dayOfMonth), moment().year(value.endDate.year).month(value.endDate.monthValue-1).date(value.endDate.dayOfMonth)]
                ])
            });
            console.log(result);
            // $('#dateTakepicker3').data("DateTimePicker").disabledDates(['17.03.2018','21.03.2018', '23.03.2018']);
            // $('#dateReturnpicker3').data("DateTimePicker").disabledDates(['17.03.2018','21.03.2018', '23.03.2018']);
        }),
        error:(function (result) {
            console.log(result)
        })
        // contentType: 'application/json'
    })/*.done(function (result) {
        console.log(result)*/
        // debugger;
        // $('#PickupTime').data("DateTimePicker").disabledTimeIntervals([
        //     [moment().hour(0), moment().hour(8).minutes(30)],
        //     [moment().hour(20).minutes(30), moment().hour(24)]
        // ])
   /* });*/
}

// $.ajax({
//     url: '/reservationdates',
//     data: data,
//     method: 'post'
// }).done(function (result) {
//     console.log(result)
        // debugger;
        // $('#PickupTime').data("DateTimePicker").disabledTimeIntervals([
        //     [moment().hour(0), moment().hour(8).minutes(30)],
        //     [moment().hour(20).minutes(30), moment().hour(24)]
        // ])
// });
// $(function () {
//     $('#dateTakepicker3').datetimepicker({
//         locale: 'ru'
//     });
//     $('#dateReturnpicker3').datetimepicker({
//         locale: 'ru'
//     });
//     $('#dateTakepicker3').data("DateTimePicker").disabledDates(['17.03.2018','21.03.2018', '23.03.2018']);
//     $('#dateReturnpicker3').data("DateTimePicker").disabledDates(['17.03.2018','21.03.2018', '23.03.2018']);
// });

// $(function () {
//     $('#datetimepicker3').datetimepicker({locale: 'ru'});
//     $("#setMinDate").click(function () {
//         $('#datetimepicker3').data("DateTimePicker").minDate(moment('17.03.2018','DD.MM.YYYY'));
//         $('#datetimepicker3').data("DateTimePicker").maxDate(moment('21.03.2018','DD.MM.YYYY'));
//         $('#datetimepicker3').data("DateTimePicker").minDate(moment('23.03.2018','DD.MM.YYYY'));
//         $('#datetimepicker3').data("DateTimePicker").maxDate(moment('25.03.2018','DD.MM.YYYY'));
//
//     });
//     $("#setMaxDate").click(function () {
//         $('#datetimepicker3').data("DateTimePicker").maxDate(moment('25.11.2020','DD.MM.YYYY'));
//         $('#datetimepicker3').data("DateTimePicker").date(null);
//     });
//     $("#show").click(function () {
//         $('#datetimepicker3').data("DateTimePicker").disabledDates(['17.03.2018','21.03.2018', '23.03.2018']);
//     });
//     $("#hide").click(function () {
//         $('#datetimepicker3').data("DateTimePicker").hide();
//     });
//     $("#disable").click(function () {
//         $('#datetimepicker3').data("DateTimePicker").disable();
//     });
//     $("#enable").click(function () {
//         $('#datetimepicker3').data("DateTimePicker").enable();
//     });
//     $("#setDate").click(function () {
//         $('#datetimepicker3').data("DateTimePicker").date(moment('15.11.2017','DD.MM.YYYY'));
//     });
//     $("#getDate").click(function () {
//         alert($('#datetimepicker3').data("DateTimePicker").date());
//     });
// });