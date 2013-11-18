/**
 * Created with JetBrains PhpStorm.
 * @author ishowshao
 * @date 13-11-18
 */
Ext.define('Admin.store.DishCategory', {
    extend: 'Ext.data.Store',
    model: 'Admin.model.Category',
    proxy: {
        type: 'ajax',
        api: config.api.category,
        reader: {
            type: 'json',
            root: 'data'
        }
    },
    autoLoad: false
});
