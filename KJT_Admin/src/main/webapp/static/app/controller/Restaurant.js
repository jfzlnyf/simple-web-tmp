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
            },
            'clone-restaurant button[action=clone]': {
                click: this.doClone
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
        this.cloneWindow = Ext.create(this.getCloneRestaurantView()).show();
    },
    onRestaurantRender: function () {
        console.log('Restaurant was rendered');
    },
    doClone: function () {
        var me = this;
        Ext.Ajax.request({
            url: config.api.clone,
            method: 'get',
            params: {
                sourceRestaurantId: this.cloneWindow.getComponent(0).getComponent(0).getValue(),
                targetRestaurantId: this.cloneWindow.getComponent(0).getComponent(1).getValue()
            },
            success: function () {
                me.cloneWindow.close();
                me.getRestaurantStore().reload();
            }
        });
    }
});
