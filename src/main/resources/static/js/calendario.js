document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
        plugins: [ 'dayGrid' ],
        defaultView: 'dayGridMonth',
        defaultDate: '2020-01-22',

        eventRender: function(info) {
            var tooltip = new Tooltip(info.el, {
                title: info.event.extendedProps.description,
                placement: 'top',
                trigger: 'hover',
                container: 'body'
            });
        },

        events: [
            {
                title: 'Consulta',
                description: 'Paciente Dolores - Doutor Tácio',
                start: '2020-01-23T16:00:00'
            },
            {
                title: 'Consulta',
                description: 'Paciente Pafuncio - Doutora Fulana',
                start: '2020-01-30T10:00:00'//,
                //end: '2019-11-10'
            }/*,
            {
                groupId: '999',
                title: 'Repeating Event',
                description: 'description for Repeating Event',
                start: '2019-11-09T16:00:00'
            },
            {
                groupId: '999',
                title: 'Repeating Event',
                description: 'description for Repeating Event',
                start: '2019-11-16T16:00:00'
            },
            {
                title: 'Conference',
                description: 'description for Conference',
                start: '2019-11-11',
                end: '2019-11-13'
            },
            {
                title: 'Meeting',
                description: 'description for Meeting',
                start: '2019-11-12T10:30:00',
                end: '2019-11-12T12:30:00'
            },
            {
                title: 'Lunch',
                description: 'description for Lunch',
                start: '2019-11-12T12:00:00'
            },
            {
                title: 'Meeting',
                description: 'description for Meeting',
                start: '2019-11-12T14:30:00'
            },
            {
                title: 'Birthday Party',
                description: 'description for Birthday Party',
                start: '2019-11-13T07:00:00'
            },
            {
                title: 'Click for Google',
                description: 'description for Click for Google',
                url: 'http://google.com/',
                start: '2019-11-28'
            }*/
        ]
    });

    calendar.render();
});