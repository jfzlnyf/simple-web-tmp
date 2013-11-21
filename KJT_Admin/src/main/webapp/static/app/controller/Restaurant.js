/**
 * Created with JetBrains PhpStorm.
 * @author ishowshao
 * @date 13-11-16
 */
Ext.define('Admin.controller.Restaurant', {
    extend: 'Ext.app.Controller',
    views: [
        'Restaurant', 'CloneRestaurant'
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
            'restaurant button[action=clone]': {
                click: this.onClone
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
    onClone: function () {
        Ext.create(this.getCloneRestaurantView()).show();
    },
    onRestaurantRender: function () {
        console.log('Restaurant was rendered');
    }
});
