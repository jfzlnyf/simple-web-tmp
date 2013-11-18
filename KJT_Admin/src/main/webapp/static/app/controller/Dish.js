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
        'Dish'
    ],
    models: [
        'Dish'
    ],
    init: function() {
        console.log('Dish controller initialized');
    }
});
