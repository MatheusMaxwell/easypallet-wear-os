package br.com.easypallet.data.models

import java.io.Serializable

data class Load (
    var id : Int,
    var code : String,
    var load_code: String?,
    var vehicle : String?,
    var vehicle_name: String?,
    var load_percentage : String,
    var check_percentage : String,
    var mounting_percentage : String,
    var assembled_percentage: String?,
    var checked_percentage: String?,
    var loaded_percentage: String?,
    var delivery_date : String,
    //var orders : List<Order>?,
    var quantity_box : Int,
    var quantity_boxes: Int?,
    var quantity_order : Int,
    var quantity_orders: Int?,
    var dock : String?,
    var weight: Double?, //new
    var released: Boolean?,
    var trip_number: String?,
    var user: String?,
    var load_type: String?,
    //var full_pallet_orders: FullPalletOrder?,
    var status: String?,
    var status_id: Int
): Serializable

