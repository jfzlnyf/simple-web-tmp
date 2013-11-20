/**
 * Created with JetBrains PhpStorm.
 * @author ishowshao
 * @date 13-11-16
 */
Ext.define('Admin.controller.Dish', {
    extend: 'Ext.app.Controller',
    views: [
        'Dish'
    ],
    stores: [
        'Dish',
        'DishCategory'
    ],
    models: [
        'Dish'
    ],
    init: function() {
        this.control({
            'dish button[action=save]': {
                click: this.onSave
            },
            'dish button[action=new]': {
                click: this.onNew
            },
            'dish combobox[action=restaurant]': {
                change: this.onRestaurantChange
            },
            'dish combobox[action=category]': {
                change: this.onCategoryChange
            },
            'dish button[action=reset]': {
                click: this.onReset
            },
            'dish button[action=delete]': {
                click: this.onDelete
            },
            'dish textfield[action=search]': {
                specialkey: this.onSearch
            }
        });
        console.log('Dish controller initialized');
    },
    onSave: function () {
        this.getDishStore().sync();
    },
    onNew: function () {
        this.getDishStore().add({
            rid: this.currentRestaurantId,
            cid: this.currentCategoryId
        });
    },
    onReset: function () {
        this.getDishStore().rejectChanges();
    },
    onRestaurantChange: function (combo) {
        this.currentRestaurantId = combo.getValue();
        this.getDishCategoryStore().load({
            params: {
                restaurant: this.currentRestaurantId
            }
        });
    },
    onCategoryChange: function (combo) {
        this.currentCategoryId = combo.getValue();
        this.getDishStore().load({
            params: {
                restaurant: this.currentRestaurantId,
                category: this.currentCategoryId
            }
        });
    },
    onSearch: function (field, e) {
        if (e.getKey() == e.ENTER) {
            this.getDishStore().load({
                params: {
                    restaurant: this.currentRestaurantId,
                    category: this.currentCategoryId,
                    keyword: field.getValue()
                }
            });
        }
    },
    onDelete: function () {
        var me = this;
        var selection = Ext.ComponentQuery.query('dish')[0].getSelectionModel().getSelection();
        var dArr = [];
        Ext.each(selection, function (i) {
            dArr.push(i.get('did'));
        });
        Ext.Ajax.request({
            url: config.api.dish.destroy,
            method: 'get',
            params: {
                dishIds: dArr.join(','),
                restaurantId: this.currentRestaurantId,
                categoryId: this.currentCategoryId
            },
            success: function (response) {
                var result = Ext.JSON.decode(response.responseText);
                if (result.success) {
                    me.getDishStore().reload();
                }
            }
        })
    }
});
