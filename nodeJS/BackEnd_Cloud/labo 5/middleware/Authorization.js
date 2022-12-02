module.exports.mustBeManager = (req, res, next) => {
    if(req.session !== undefined && req.session.authLevel === "manager"){
        next();
    } else {
        res.sendStatus(403);
    }
}
