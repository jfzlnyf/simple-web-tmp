/**
 * Created with JetBrains PhpStorm.
 * @author ishowshao
 * @date 13-11-16
 */
Ext.define('Admin.model.Dish', {
    extend: 'Ext.data.Model',
    fields: [
        { name: 'did', type: 'string', defaultValue: '' },
        { name: 'rid', type: 'string', defaultValue: '' },
        { name: 'cid', type: 'string', defaultValue: '' },
        { name: 'enName', type: 'string', defaultValue: '' },
        { name: 'cnName', type: 'string', defaultValue: '' },
        { name: 'exName', type: 'string', defaultValue: '' },
        { name: 'description', type: 'string', defaultValue: '' },
        { name: 'status', type: 'string', defaultValue: 'normal' },
        { name: 'manualPriority', defaultValue: null },
        { name: 'manualPriority2', defaultValue: null },
        { name: 'autoPriority', defaultValue: null },
        { name: 'autoPriority2', defaultValue: null },
        { name: 'subgroup', defaultValue: null },
        { name: 'size1', defaultValue: null },
        { name: 'size2', defaultValue: null },
        { name: 'size3', defaultValue: null },
        { name: 'size4', defaultValue: null },
        { name: 'lunchSpecial', defaultValue: null },
        { name: 'dinnerSpecial', defaultValue: null },
        { name: 'printerMask', defaultValue: 1 }
    ]
});
