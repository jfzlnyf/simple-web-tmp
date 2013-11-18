/**
 * Created with JetBrains PhpStorm.
 * @author ishowshao
 * @date 13-11-16
 */
Ext.define('Admin.controller.Restaurant', {
    extend: 'Ext.app.Controller',
    views: [
        'Restaurant'
    ],
    stores: [
        'Restaurant'
    ],
    models: [
        'Restaurant'
    ],
    init: function() {
        console.log('Restaurant controller initialized');
        this.control({
            'restaurant button[action=save]': {
                click: this.onSave
            },
            'restaurant button[action=new]': {
                click: this.onNew
            }
        });
        this.control({
            'restaurant': {
                render: this.onRestaurantRender
            }
        });
    },
    onSave: function () {
        console.log('save');
        this.getRestaurantStore().sync();
    },
    onNew: function () {
        console.log('new');
        this.getRestaurantStore().add(Ext.create('Admin.model.Restaurant'));
//        this.getRestaurantStore().sync();
    },
    onRestaurantRender: function () {
        console.log('Restaurant was rendered');
    }
});
