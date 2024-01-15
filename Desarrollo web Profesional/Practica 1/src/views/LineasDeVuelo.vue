<template>
    <div>
        <b-container fluid>
            <b-row>
                <b-col>
                    <BreadcrumVuelosDisponibles/>
                </b-col>
            </b-row>
            <b-row>
                <b-col>
                    <h1>Lineas de vuelo</h1>
                </b-col>
            </b-row>
        </b-container>
    </div>
</template>

<script>
export default {
    name: 'LineasDeVuelo',
    components: {
        BreadcrumVuelosDisponibles: () =>
            import ('@/components/breadscrumb/BreadcrumVuelosDisponibles.vue'),
    },
}
</script>