package com.daveepro.demomarket.persistence.mapper;

import com.daveepro.demomarket.domain.PurchaseItem;
import com.daveepro.demomarket.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "estado", target = "active"),
    })
    PurchaseItem toPurchaseItem(ComprasProducto producto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target="compra", ignore = true),
            @Mapping(target="producto", ignore = true),
            @Mapping(target="id.idCompra", ignore = true),
    })
    ComprasProducto toComprasProducto(PurchaseItem item);
}
