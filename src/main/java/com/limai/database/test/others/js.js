function getQRCodeInfo(qrCode) {
    var info = {};
    if (qrCode && qrCode.indexOf("hlht://") === 0) {
        qrCode = qrCode.substr(7);
        var ids = qrCode.substring(0, qrCode.indexOf("/")).split("\.");
        info.operatorId = ids[1];
        info.connectorId = ids[0];
    }
    return JSON.stringify(info);
}

function getQRCodeInfo(qrCode) {
    var info = {};
    if (qrCode && qrCode.indexOf("https://qrcode.camsnetec.com") === 0) {
        info.operatorId = "MA59J8YL8";
        info.connectorId = qrCode.substring(32);
    }
    returnJSON.stringify(info);
}

function getQRCodeInfo(qrCode) {
    var info = {};
    if (qrCode && qrCode.indexOf("https://qrcode.starcharge.com") === 0) {
        info.operatorId = "313744932";
        info.connectorId = qrCode.substring(32);
    }
    returnJSON.stringify(info);
}


function getTotalFeeInfo(electricityFee, serviceFee) {
    var info = [[1200, 0.1200, 0.0600], [2359, 0.1200, 0.0600]];
    return JSON.stringify(info);
}