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
//        console.log('Category controller initialized');
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
            },
            'category button[action=delete]': {
                click: this.onDelete
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
    },
    onDelete: function () {
        var me = this;
        var selection = Ext.ComponentQuery.query('category')[0].getSelectionModel().getSelection();
        var cArr = [];
        Ext.each(selection, function (i) {
            cArr.push(i.get('cid'));
        });
        Ext.Ajax.request({
            url: config.api.category.destroy,
            method: 'get',
            params: {
                categoryIds: cArr.join(','),
                restaurantId: this.currentRestaurantId
            },
            success: function (response) {
                var result = Ext.JSON.decode(response.responseText);
                if (result.success) {
                    me.getCategoryStore().reload();
                }
            }
        })
    }
});
