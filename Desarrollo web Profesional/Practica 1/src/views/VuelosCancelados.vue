<template>
    <div>
        <b-container fluid>
            <b-row>
                <b-col>
                    <BreadcrumVuelosCancelados/>
                </b-col>
            </b-row>
            <b-row>
                <b-col>
                    <h1>Vuelos cancelados</h1>
                </b-col>
            </b-row>
        </b-container>
    </div>
</template>

<script>
export default {
    name: 'VuelosCancelados',
    components: {
        BreadcrumVuelosCancelados: () =>
            import ('@/components/breadscrumb/BreadcrumVuelosCancelados.vue'),
    },
}
</script>