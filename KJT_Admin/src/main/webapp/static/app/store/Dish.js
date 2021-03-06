/**
 * Created with JetBrains PhpStorm.
 * @author ishowshao
 * @date 13-11-16
 */
Ext.define('Admin.store.Dish', {
    extend: 'Ext.data.Store',
    model: 'Admin.model.Dish',
    proxy: {
        type: 'ajax',
        api: config.api.dish,
        reader: {
            type: 'json',
            root: 'data'
        }
    },
    autoLoad: true
});
