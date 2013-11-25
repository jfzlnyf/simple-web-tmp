/**
 * Created with JetBrains PhpStorm.
 * @author ishowshao
 * @date 13-11-15
 */
Ext.define('Admin.controller.Menu', {
    extend: 'Ext.app.Controller',

    views: [
        'Menu'
    ],

    init: function() {
//        console.log('Menu controller initialized');
        this.control({
            'viewport > treepanel': {
                render: this.onPanelRendered,
                itemclick: this.onItemClick
            }
        });
    },

    onPanelRendered: function() {
//        console.log('Menu was rendered');
    },
    onItemClick: function (node, record) {
        var viewport = Ext.ComponentQuery.query('viewport')[0];
        viewport.getComponent('center').items.each(function (item) {
            item.hide();
        });
        viewport.getComponent('center').getComponent(record.get('id')).show();
//        document.location.hash = '#!/' + record.get('id');
    }
});
