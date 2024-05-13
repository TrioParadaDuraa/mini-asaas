package utils

abstract class BaseDomain {

    Date dateCreated
    Date lastUpdated
    Boolean deleted = false
    static mapping = {
        tablePerHierarchy false
    }

}