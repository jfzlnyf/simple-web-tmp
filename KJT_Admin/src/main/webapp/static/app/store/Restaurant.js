/**
 * Created with JetBrains PhpStorm.
 * @author ishowshao
 * @date 13-11-16
 */
Ext.define('Admin.store.Restaurant', {
    extend: 'Ext.data.Store',
    model: 'Admin.model.Restaurant',
    proxy: {
        type: 'ajax',
        api: config.api.restaurant,
        reader: {
            type: 'json',
            root: 'data'
        }
    },
    autoLoad: true
});
