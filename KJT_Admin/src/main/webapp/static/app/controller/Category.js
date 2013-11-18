/**
 * Created with JetBrains PhpStorm.
 * @author ishowshao
 * @date 13-11-16
 */
Ext.define('Admin.controller.Category', {
    extend: 'Ext.app.Controller',
    views: [
        'Category'
    ],
    stores: [
        'Category'
    ],
    models: [
        'Category'
    ],
    init: function() {
        console.log('Category controller initialized');
        this.control({
            'category button[action=save]': {
                click: this.onSave
            },
            'category button[action=new]': {
                click: this.onNew
            },
            'category combobox[action=restaurant]': {
                change: this.onRestaurantChange
            },
            'category button[action=reset]': {
                click: this.onReset
            }
        });
    },
    onSave: function () {
        this.getCategoryStore().sync();
    },
    onNew: function () {
        this.getCategoryStore().add({
            rid: this.currentRestaurantId
        });
    },
    onRestaurantChange: function (combo) {
        this.currentRestaurantId = combo.getValue();
        this.getCategoryStore().load({
            params: {
                restaurant: combo.getValue()
            }
        });
    },
    onReset: function () {
        this.getCategoryStore().rejectChanges();
    }
});
